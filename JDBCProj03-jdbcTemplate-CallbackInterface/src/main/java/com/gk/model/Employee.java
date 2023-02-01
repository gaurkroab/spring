package com.gk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int empno;
	private String ename;
	private String job;
	private float sal;
	private int deptno;
}
