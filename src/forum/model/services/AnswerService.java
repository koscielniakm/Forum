package forum.model.services;

import java.util.Date;

import forum.model.dao.DaoAnswer;
import forum.model.dao.DaoTopic;
import forum.model.dao.DaoUser;
import forum.model.entities.AnswerEntity;
import forum.model.entities.TopicEntity;
import forum.model.entities.UserEntity;

public class AnswerService {

	private DaoAnswer answerAccess;
	private DaoTopic topicAccess;
	private DaoUser userAccess;
	
	public AnswerService() {
		answerAccess = new DaoAnswer();
		topicAccess = new DaoTopic();
		userAccess = new DaoUser();
	}
	
	public void insertAnswer(Integer authorId, Integer topicId, String answerContent) {
		if (authorId > 0 && topicId > 0 && answerContent != "") {
			UserEntity author = userAccess.findById(authorId);
			TopicEntity topic = topicAccess.findById(topicId);
			AnswerEntity currentAnswer = new AnswerEntity();
			currentAnswer.setAnswerAuthor(author);
			currentAnswer.setAnswerTopic(topic);
			currentAnswer.setContent(answerContent);
			currentAnswer.setPostDate(new Date());
			answerAccess.create(currentAnswer);
		}
	}
	
}