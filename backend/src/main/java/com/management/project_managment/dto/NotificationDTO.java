package com.management.project_managment.dto;

import java.io.Serializable;
import java.time.Instant;

import com.management.project_managment.entities.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NotificationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String text;
	private Instant moment;
	private boolean read;
	private String route;
	private Long userId;

	public NotificationDTO(Notification entity) {
		id = entity.getId();	
		text = entity.getText();
		moment = entity.getMoment();
		read = entity.isRead();
		route = entity.getRoute();
		userId = entity.getUser().getId();
	}
}
