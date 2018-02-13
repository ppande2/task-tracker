package com.tt.services.imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tt.dao.api.TaskDAO;
import com.tt.domain.Task;
import com.tt.services.api.TaskSchedule;

@Configuration
@EnableScheduling
@Service
public class TaskScheduleImp implements TaskSchedule {
	
	@Autowired
	TaskDAO taskdao;
	
	@Autowired
	MailSender mailSender;
	
	List<Task> taskList;
	
	 public void sendMail(String toAddress, String fromAddress, String subject, String msgBody){
		 
		 	SimpleMailMessage mailData = new SimpleMailMessage();
		 	mailData.setFrom(fromAddress);
		 	mailData.setTo(toAddress);
		 	mailData.setSubject(subject);
		 	mailData.setText(msgBody);
			mailSender.send(mailData);
		 
		 
	 }
	
	 @Scheduled(fixedDelay = 10000)
	 public void sendMailToUserForTasks(){
		
		System.out.println("Baby is always beutiful");
		
		taskList=taskdao.getAllTasksToSendEmail();
		/*for (int i=0 ;i<taskList.size();i++){

			sendMail(taskList.get(i).getUserId(),"pankajiet.pandey@gmail.com",taskList.get(i).getTaskName(),taskList.get(i).getTaskDescription());
		}*/
		
//		sendMail("pandeyiet.pankaj@gmail.com","pankajiet.pandey@gmail.com","Hi","Cool");
		
	}

}
