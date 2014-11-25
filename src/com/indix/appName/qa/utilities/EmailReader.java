package com.indix.appName.qa.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.SortTerm;

public class EmailReader {

	public String readMailAndFetchText(String username, String password, String textToCheck) {

		String emailSubject = "wants you to see this item at Amazon.com ";

		boolean foundMail = false;
		String sCurrentLine = null;
		try {
			Properties properties = new Properties();
			Session session = Session.getInstance(properties);
			Store store = session.getStore("imaps");
			store.connect("64.233.185.109", username, password);

			SortTerm[] term = new SortTerm[2];
			term[1] = SortTerm.DATE;
			term[0] = SortTerm.REVERSE;

			// term[0] = SortTerm.DATE;
			IMAPFolder inbox = (IMAPFolder) store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			Folder folder = store.getFolder("INBOX");
			System.out.println(folder.getFullName());
			folder.open(Folder.READ_ONLY);
			Message[] messages = inbox.getSortedMessages(term);

			for (Message m : messages) {
				System.out.println(m.getSubject());

				{
					String bp = ((String) m.getContent());

					System.out.println("SUBJECT:" + m.getSubject());
					System.out.println("SUBJECT:" + m.getSentDate());
					if (m.getSubject().toLowerCase().contains(emailSubject.toLowerCase())) {

						BufferedReader br = new BufferedReader(new StringReader(bp));
						while ((sCurrentLine = br.readLine()) != null) {
							System.out.println(sCurrentLine);
							if (sCurrentLine.contains(textToCheck.toLowerCase())) {
								foundMail = true;
								break;
							}
						}
					}

					if (foundMail)
						break;
				}

			}

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sCurrentLine;
	}

}
