package com.gem.qqzone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gem.qqzone.dao.base.AbstractParser;
import com.gem.qqzone.dao.base.BaseDAO;
import com.gem.qqzone.pojo.HostReply;
import com.gem.qqzone.pojo.Reply;
import com.gem.qqzone.pojo.User;

public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
	
	private class ReplyParser extends AbstractParser<Reply>{

		@Override
		public Set<Reply> parseRS(ResultSet rs) {
			Set<Reply> replies = new HashSet<Reply>();
			try {
				while(rs.next()){
					int id = rs.getInt(1);
					String content = rs.getString(2);
					Date replyDate = rs.getTimestamp(3);
					int hostReplyId = rs.getInt(6);
					HostReply hostReply = null ;
					if(hostReplyId!=0){
						String hostReplyContent = rs.getString(7);
						Date hostReplyDate = rs.getTimestamp(8);
						hostReply = new HostReply(hostReplyId , hostReplyContent , hostReplyDate);
					}
					int authorId = rs.getInt(10);
					String nickName = rs.getString(13);
					String headImg = rs.getString(14);
					User replyUser = new User(authorId , nickName , headImg) ;
					Reply reply = new Reply(id, content, replyDate, replyUser, hostReply);
					replies.add(reply);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return replies;
		}
	}
	
	private ReplyParser parser = new ReplyParser();

	public Set<Reply> getReplies(int topicId) {
		String sql = "select * from t_reply t1 left join t_host_reply t2 on t1.id = t2.replyId inner join t_user t3 on t1.author = t3.id where t1.topicId = ?" ;
		return super.executeQuery(parser, sql, topicId);
	}

}
