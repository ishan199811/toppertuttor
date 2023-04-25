package com.toppertutors.service;

import java.util.List;


import com.toppertutors.entity.Contact;
import com.toppertutors.entity.playload.ResponseMessage;

public interface ContactService {

	String save(Contact contact);











	List<Contact> findByContactId();











	Contact get(long id);











	void delete(long id);

}
