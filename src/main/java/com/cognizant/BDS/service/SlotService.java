package com.cognizant.BDS.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.Feedback;
import com.cognizant.BDS.model.Slot;
import com.cognizant.BDS.repository.FeedbackRepository;
import com.cognizant.BDS.repository.SlotRepository;

@Service
public class SlotService {
	
	@Autowired
	private SlotRepository slotRepository;

	public SlotService(SlotRepository slotRepository) {
		super();
		this.slotRepository = slotRepository;
	}
	
	public Set<Slot> getAllSlot(){
		return slotRepository.getAllSlot();
	}
	
	public Long checkIfASlotIsBooked(Slot slot){
		int cityId = slotRepository.getCityIdByCityName(slot.getCity());
		return slotRepository.getCountOfSlotByInput(slot.getHospitalName(), cityId, slot.getDate().toString(), slot.getTime().toString() );
	}
	
	public int bookSlot(Slot slot){
		int cityId = slotRepository.getCityIdByCityName(slot.getCity());
		return slotRepository.insertSlot(slot.getHospitalName(),cityId,slot.getDate().toString(),slot.getTime().toString(),slot.getDonorId());
	}

}
