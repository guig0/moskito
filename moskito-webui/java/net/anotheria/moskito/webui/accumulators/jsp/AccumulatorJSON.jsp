<%@ page language="java" contentType="application/json;charset=UTF-8" session="true"
%><%@ taglib uri="http://www.anotheria.net/ano-tags" prefix="ano"
%>{
	"accumulatorInfo" : {
		"id": "<ano:write name="accumulatorInfo" property="id"/>",
		"name": "<ano:write name="accumulatorInfo" property="name"/>",
		"path": "<ano:write name="accumulatorInfo" property="path"/>",
		"numberOfValues": "<ano:write name="accumulatorInfo" property="numberOfValues"/>",
        "maxNumberOfValues": "<ano:write name="accumulatorInfo" property="maxNumberOfValues"/>",
        "lastValueTimestamp": "<ano:write name="accumulatorInfo" property="lastValueTimestamp"/>"
	},
	"accumulatorData" : [
	<ano:iterate name="accumulatorData" property="data" id="row" indexId="ind"
		><ano:notEqual name="ind" value="0">,</ano:notEqual>
		{"timestamp": "<ano:write name="row" property="isoTimestamp"/>", "value": "<ano:write name="row" property="firstValue"/>"}</ano:iterate>
	]
}
