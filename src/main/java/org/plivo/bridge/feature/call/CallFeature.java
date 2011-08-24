package org.plivo.bridge.feature.call;

/**
 * Copyright (c) 2011 Plivo Team. See LICENSE for details.
 *  2011-05-23
 * @author Paulo reis
 */

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.plivo.bridge.client.PlivoClient;
import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.feature.base.BaseFeature;
import org.plivo.bridge.to.response.BulkCallResponse;
import org.plivo.bridge.to.response.CallResponse;
import org.plivo.bridge.to.response.CancelScheduleHangupResponse;
import org.plivo.bridge.to.response.CancelSchedulePlayResponse;
import org.plivo.bridge.to.response.GroupCallResponse;
import org.plivo.bridge.to.response.HangupAllCallResponse;
import org.plivo.bridge.to.response.HangupCallResponse;
import org.plivo.bridge.to.response.PlayResponse;
import org.plivo.bridge.to.response.PlayStopResponse;
import org.plivo.bridge.to.response.RecordStartResponse;
import org.plivo.bridge.to.response.RecordStopResponse;
import org.plivo.bridge.to.response.ScheduleHangupResponse;
import org.plivo.bridge.to.response.SchedulePlayResponse;
import org.plivo.bridge.to.response.SoundTouchResponse;
import org.plivo.bridge.to.response.SoundTouchStopResponse;
import org.plivo.bridge.to.response.TransfCallResponse;
import org.plivo.bridge.utils.PlivoUtils;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class CallFeature extends BaseFeature {

	public CallFeature(PlivoClient client, WebResource baseResource) {
		super(client, baseResource);
	}

	public CallResponse single(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			CallResponse response = this.getBaseResource()
					.path("Call/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(CallResponse.class,
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return response;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public BulkCallResponse bulk(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			BulkCallResponse result = this.getBaseResource()
					.path("BulkCall/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(BulkCallResponse.class, 
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	public GroupCallResponse group(Map<String, String> parameters) throws PlivoClientException {

		try {
			GroupCallResponse result = this.getBaseResource()
					.path("GroupCall/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(GroupCallResponse.class, 
							PlivoUtils.ParameterUtils.mapToForm(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public TransfCallResponse transfer(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			TransfCallResponse result = this.getBaseResource()
				.path("TransferCall/")
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.post(TransfCallResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public HangupCallResponse hangUp(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			HangupCallResponse result = this.getBaseResource()
					.path("HangupCall/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(HangupCallResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public HangupAllCallResponse hangUpAll(Map<String, String> parameters)
			throws PlivoClientException {
		
		try {
			HangupAllCallResponse result = this.getBaseResource()
					.path("HangupAllCalls/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(HangupAllCallResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public ScheduleHangupResponse scheduleHangup(Map<String, String> parameters)
			throws PlivoClientException {
		try {
			ScheduleHangupResponse result = this.getBaseResource()
					.path("ScheduleHangup/")
					.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(ScheduleHangupResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public CancelScheduleHangupResponse cancelScheduledHangup(Map<String, String> parameters)
			throws PlivoClientException {

		try {
			CancelScheduleHangupResponse result = this.getBaseResource()
					.path("CancelScheduledHangup/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(CancelScheduleHangupResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	public RecordStartResponse recordStart(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			RecordStartResponse result = this.getBaseResource()
					.path("RecordStart/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(RecordStartResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
	
	public RecordStopResponse recordStop(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			RecordStopResponse result = this.getBaseResource()
					.path("RecordStop/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(RecordStopResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public PlayResponse play(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			PlayResponse result = this.getBaseResource()
					.path("Play/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(PlayResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public PlayStopResponse playStop(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			PlayStopResponse result = this.getBaseResource()
					.path("PlayStop/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(PlayStopResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public SchedulePlayResponse schedulePlay(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			SchedulePlayResponse result = this.getBaseResource()
					.path("SchedulePlay/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(SchedulePlayResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public CancelSchedulePlayResponse cancelSchedulePlay(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			CancelSchedulePlayResponse result = this.getBaseResource()
					.path("CancelSchedulePlay/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(CancelSchedulePlayResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public SoundTouchResponse soundTouch(
			Map<String, String> parameters) throws PlivoClientException {
		
		try {
			SoundTouchResponse result = this.getBaseResource()
					.path("SoundTouch/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(SoundTouchResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}

	public SoundTouchStopResponse soundTouchStop(Map<String, String> parameters) throws PlivoClientException {
		
		try {
			SoundTouchStopResponse result = this.getBaseResource()
					.path("SoundTouchStop/")
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.post(SoundTouchStopResponse.class, PlivoUtils.ParameterUtils.mapToForm(parameters));
			
			return result;
		} catch (UniformInterfaceException e) {
			throw new PlivoClientException(e);
		}
	}
}
