package com.toppertutors.service;

import java.util.List;

import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;

public interface HireTuttorService {

	String save(HireTuttor hire);

	List<HireTuttor> findByHireTuttorId();

	void delete(long id);

}
