package com.tt.services.api;

import com.tt.domain.Task;

public interface TaskSchedule {
	
	public void sendMailToUserForTasks();
	public void sendMail(String toAddress, String fromAddress, String subject, String msgBody);

}
