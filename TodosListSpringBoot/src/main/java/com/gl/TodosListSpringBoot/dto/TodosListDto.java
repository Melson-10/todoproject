package com.gl.TodosListSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodosListDto {
	private long id;
	private String todoTitle;
	private String todoDescription;
	private String todoCompleted;

}
