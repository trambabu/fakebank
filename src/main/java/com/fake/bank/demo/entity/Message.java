package com.fake.bank.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fake.bank.demo.user.Users;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="message_id", nullable=false, updatable=false)
	private Long messageId;
	
	private String subject;
	private String content;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date timestamp;
	
	@ManyToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Users users;
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

}
