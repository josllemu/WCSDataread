select
    Lev.createdDate, sup.salesOrderNumber as 'SAP OrderNr', Lev.orderNumber as 'Leveringsnummer', Part.cvr as 'Kundenummer',
  	Part.orderSUB as 'Order sub', Sto.qty as 'antal', ic.itemConf as 'enhed', it.item_code as 'varenr', it.description as 'beskrivelse',
  	Oper.barcode as 'Ekstern kolli', Oper.user as 'medarbejder navn', Oper.jobType as logType, Oper.timestamp as Dato, Oper.jobType as logtypekode,
	Oper.zone as kø, Oper.fromLocation as lokation,
  	(Case LENGTH(Col.route) WHEN 2 THEN
	    (CASE Col.zipCodeArea WHEN 'NORD' THEN '01'
	        WHEN 'MIDT' THEN '02'
			WHEN 'VEST' THEN '03'
			WHEN 'THIS' THEN '04'
			WHEN 'THIS' THEN '04'
			WHEN 'SYD'  THEN '05'
			WHEN 'VOJ'  THEN '06'
			WHEN 'ODE'  THEN '07'
			WHEN 'KOL'  THEN '08'
			WHEN 'GLO'  THEN '09'
			WHEN 'SJÆL' THEN '10'
			WHEN 'KBH1' THEN '11'
			WHEN 'TAS1' THEN '12'
			WHEN 'TAS2' THEN '13'
			WHEN 'FRAG' THEN '14'
			WHEN 'SCM'  THEN '15'
			WHEN 'BORN' THEN '16'
		ELSE '16'  END)
	ELSE '' END) + Col.route as rute,



  FROM wmsorder AS Lev

  LEFT OUTER JOIN Supply as sup
    on sup.orderId = Lev.orderId
	/*AND DATE(Lev.dbDate) = curDATE() AND DATE(sup.dbDate) = curDate()*/
  Inner Join partneraddress AS Part
    On Lev.orderId = Part.orderID
	And Part.orderSUB = 'EA'

  Inner Join operatorevent AS Oper
    On Oper.orderNumber = Lev.orderNumber
	And Oper.jobType in ( 'PICK' , 'PACK' , 'FULL')


  Inner Join Item AS it
    On it.item_code  = Oper.item
	Inner join itemconf as ic on it.item_code = ic.item

  left join customerlabel As Col
	   On Date(Oper.timestamp) = Date(Col.packDate)
	   And Lev.orderNumber = Col.orderNumber

   Inner Join Stock As Sto
       On Sto.allocRef = Oper.allocRef where sup.salesOrderNumber = '0415551364';
