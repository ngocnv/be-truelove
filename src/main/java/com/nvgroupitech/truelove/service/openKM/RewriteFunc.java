package com.nvgroupitech.truelove.service.openKM;

import com.openkm.sdk4j.exception.AccessDeniedException;
import com.openkm.sdk4j.exception.DatabaseException;
import com.openkm.sdk4j.exception.PathNotFoundException;
import com.openkm.sdk4j.exception.RepositoryException;
import com.openkm.sdk4j.exception.UnknowException;
import com.openkm.sdk4j.exception.WebserviceException;
import com.openkm.sdk4j.impl.ClientImpl;
import com.openkm.sdk4j.util.UriHelper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.representation.Form;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class RewriteFunc extends ClientImpl {
	private String url = "";
	private String user = "";
	private String pass = "";

	public RewriteFunc(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public void grantUser(String nodeId, String role, int permissions, boolean recursive)
			throws AccessDeniedException, RepositoryException, DatabaseException, PathNotFoundException,
			UnknowException, WebserviceException, KeyManagementException, NoSuchAlgorithmException {
		Client client = this.getClient(this.user, this.pass, this.url);

		try {
			String uri = UriHelper.getUri(this.url, "services/rest/auth/grantUser");
			Form formParam = new Form();
			formParam.add("nodeId", nodeId);
			formParam.add("user", role);
			formParam.add("permissions", permissions);
			formParam.add("recursive", recursive);
			WebResource resource = client.resource(uri);
			ClientResponse cResponse = (ClientResponse) ((Builder) resource.accept(new String[]{"application/xml"})
					.type("application/x-www-form-urlencoded")).put(ClientResponse.class, formParam);
			if (cResponse.getStatus() != Status.NO_CONTENT.getStatusCode()) {
				String error = (String) cResponse.getEntity(String.class);
				if (cResponse.getStatus() == Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
					if (error.indexOf(":") > 0) {
						String className = error.substring(0, error.indexOf(":"));
						String msg = error.substring(error.indexOf(":") + 1);
						if (className.equals("AccessDeniedException")) {
							throw new AccessDeniedException(msg);
						}

						if (className.equals("DatabaseException")) {
							throw new DatabaseException(msg);
						}

						if (className.equals("PathNotFoundException")) {
							throw new PathNotFoundException(msg);
						}

						if (className.equals("RepositoryException")) {
							throw new RepositoryException(msg);
						}

						throw new UnknowException("HTTP error code " + cResponse.getStatus() + ": " + error);
					}

					throw new UnknowException("HTTP error code " + cResponse.getStatus() + ": " + error);
				}

				throw new UnknowException(error);
			}
		} catch (ClientHandlerException var16) {
			throw new WebserviceException(var16);
		} finally {
			if (client != null) {
				client.destroy();
			}

		}

	}
}