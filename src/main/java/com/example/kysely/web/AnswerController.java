package com.example.kysely.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kysely.model.Answer;
import com.example.kysely.model.AnswerRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;

@CrossOrigin
@Controller
public class AnswerController {

	@Autowired
	private QuestionRepo questionRepository;

	@Autowired
	private AnswerRepo answerRepository;

	// REST list answers by questions
	@GetMapping("/questions/{id}/answers")
	public @ResponseBody List<Answer> findAnswersByQuestion(@PathVariable("id") Long questionId) {
		Question question = questionRepository.findById(questionId).orElse(null);
		return answerRepository.findByQuestion(question);
	}

	@GetMapping("/answers")
	public @ResponseBody List<Answer> findAllAnswers() {

		return (List<Answer>) answerRepository.findAll();

	}

	// REST save answers

	@PostMapping(value = "/answers")

	public @ResponseBody List<Answer> saveAnswers(@RequestBody List<Answer> answers) throws Exception {
		List<Answer> savedAnswers = new ArrayList<Answer>();

		for (int i = 0; i < answers.size(); i++) {
			Question question = questionRepository.findById(answers.get(i).getQuestion().getId()).orElse(null);
			Answer answer = new Answer(answers.get(i).getContent(), question);

			answerRepository.save(answer);
			savedAnswers.add(answer);
		}

		return savedAnswers;
	} 
	
	@PostMapping(value = "/answer")

	public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) throws Exception {
		//Answer savedAnswer = new Answer();

			answerRepository.save(answer);
			
		return answer;
	}

}
