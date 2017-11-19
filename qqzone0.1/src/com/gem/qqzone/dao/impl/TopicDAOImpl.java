package com.gem.qqzone.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gem.qqzone.dao.TopicDAO;
import com.gem.qqzone.dao.base.AbstractParser;
import com.gem.qqzone.dao.base.BaseDAO;
import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;

public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
	
	private class TopicParser extends AbstractParser<Topic>{

		@Override
		public Set<Topic> parseRS(ResultSet rs) {
			Set<Topic> topics = new HashSet<Topic>();
			try {
				while(rs.next()){
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String content= rs.getString(3);
					Date topicDate = rs.getTimestamp(4);
					int authorId = rs.getInt(5);
					User author = new User(authorId);
					Topic topic = new Topic(id, title, content, topicDate, author);
					topics.add(topic);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return topics ;
		}

		@Override
		public Topic loadRS(ResultSet rs) {
			try {
				if(rs.next()){
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String content= rs.getString(3);
					Date topicDate = rs.getTimestamp(4);
					int authorId = rs.getInt(5);
					User author = new User(authorId);
					return new Topic(id, title, content, topicDate, author);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null ;
		}
		
		
	}
	
	private TopicParser parser = new TopicParser();

	public Set<Topic> getTopics(int userId) {
		String sql = "select * from t_topic where author = ? " ;
		return super.executeQuery(parser, sql, userId);
	}

	public Topic getTopic(int id) {
		String sql = "select * from t_topic where id = ? " ;
		return super.load(parser, sql, id);
	}

	
}
