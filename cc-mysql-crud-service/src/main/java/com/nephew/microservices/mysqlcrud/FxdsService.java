package com.nephew.microservices.mysqlcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FxdsService {

	@Autowired
	private FxdsResponseRepository repo;
	
	public void saveFxdsResponse(FxdsRoot root) {
		for (FxdsResponse response : root.getResponse()) {
			repo.save(response);
		}
	}
	
}
