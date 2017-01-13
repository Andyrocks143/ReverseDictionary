function validate()
{
	
	
	
	var s=document.getElementById("pharse").value;
	

	
	if(s==null || s=="")
		{
		
		document.getElementById("info").innerHTML="Enter a sentense or Pharse ";
		}
	   
	else if(/^[a-zA-Z0-9- ]*$/.test(s) == false)
		{
		
		document.getElementById("info").innerHTML="Special Charector not allowded";
		
		}
	else if(s.length==1)
	  {

	document.getElementById("info").innerHTML="Please Enter More than One word";
	}
	else
		{
		reverseMe(s);
		}
}



function reverseMe(s)
{

	
	xmlHttp = GetXmlHttpObject();
	var url = "/ReverseDictionaryPro/ReverseDict?pharse=" + s;
 	xmlHttp.onreadystatechange = getReplay;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

function getReplay() 
{
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
		var showdata = xmlHttp.responseText;
		alert(showdata);
		//if(showdata=="failed")
			//{
			//document.getElementById("info").innerHTML="no data";
			//}
		//else
			//{
		var result="<h2><b><u>Result</u></b></h2>";
		document.getElementById("info").innerHTML=result+showdata;
		//}
}}
function GetXmlHttpObject() {
	var xmlHttp = null;
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}
