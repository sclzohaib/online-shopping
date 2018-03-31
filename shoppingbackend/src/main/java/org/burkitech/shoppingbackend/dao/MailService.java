package org.burkitech.shoppingbackend.dao;

public interface MailService {

	public void sendSimpleMessage(String to, String subject, String text);

}
