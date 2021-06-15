package com.mycompany.ucsa.dto;


import java.time.LocalDate;

import com.mycompany.ucsa.dto.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse1 {

	private int admissionId;
	private int courseId;
	private int applicantId;
	private java.util.Date admissionDate;
}