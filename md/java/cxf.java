# wadl的注释
   http://cxf.apache.org/docs/jaxrs-services-description.html#JAXRSServicesDescription-DocumentingresourceclassesandmethodsinWADL
`Java
@Descriptions({ 
   @Description(value = "Adds a new book", target = DocTarget.METHOD),
	   @Description(value = "Requested Book", target = DocTarget.RETURN),
	   @Description(value = "Request", target = DocTarget.REQUEST),
	   @Description(value = "Response", target = DocTarget.RESPONSE),
	   @Description(value = "Resource", target = DocTarget.RESOURCE)
})
`
