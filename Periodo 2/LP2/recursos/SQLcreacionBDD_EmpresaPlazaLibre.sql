use EmpresaPlazaLibre
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE TABLE [dbo].[Categories](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](15) NOT NULL,
	[Description] [ntext] NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

CREATE TABLE [dbo].[Suppliers](
	[SupplierID] [int] IDENTITY(1,1) NOT NULL,
	[CompanyName] [nvarchar](40) NOT NULL,
	[ContactName] [nvarchar](30) NULL,
	[ContactTitle] [nvarchar](30) NULL,
	[Address] [nvarchar](60) NULL,
	[City] [nvarchar](15) NULL,
	[Region] [nvarchar](15) NULL,
	[PostalCode] [nvarchar](10) NULL,
	[Country] [nvarchar](15) NULL,
	[Phone] [nvarchar](24) NULL,
	[Fax] [nvarchar](24) NULL,
	[HomePage] [ntext] NULL,
 CONSTRAINT [PK_Suppliers] PRIMARY KEY CLUSTERED 
(
	[SupplierID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO


IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Products_Categories]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FK_Products_Categories]
GO

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Products_Suppliers]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FK_Products_Suppliers]
GO

IF  EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[CK_Products_UnitPrice]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [CK_Products_UnitPrice]
GO

IF  EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[CK_ReorderLevel]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [CK_ReorderLevel]
GO

IF  EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[CK_UnitsInStock]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [CK_UnitsInStock]
GO

IF  EXISTS (SELECT * FROM sys.check_constraints WHERE object_id = OBJECT_ID(N'[dbo].[CK_UnitsOnOrder]') AND parent_object_id = OBJECT_ID(N'[dbo].[Products]'))
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [CK_UnitsOnOrder]
GO

IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Products_UnitPrice]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [DF_Products_UnitPrice]
END

GO

IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Products_UnitsInStock]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [DF_Products_UnitsInStock]
END

GO

IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Products_UnitsOnOrder]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [DF_Products_UnitsOnOrder]
END

GO

IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Products_ReorderLevel]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [DF_Products_ReorderLevel]
END

GO

IF  EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[DF_Products_Discontinued]') AND type = 'D')
BEGIN
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [DF_Products_Discontinued]
END

GO


IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Products]') AND type in (N'U'))
DROP TABLE [dbo].[Products]
GO



CREATE TABLE [dbo].[Products](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](40) NOT NULL,
	[SupplierID] [int] NULL,
	[CategoryID] [int] NULL,
	[QuantityPerUnit] [nvarchar](20) NULL,
	[UnitPrice] [money] NULL,
	[UnitsInStock] [smallint] NULL,
	[UnitsOnOrder] [smallint] NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Products]  WITH NOCHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO

ALTER TABLE [dbo].[Products]  WITH NOCHECK ADD  CONSTRAINT [FK_Products_Suppliers] FOREIGN KEY([SupplierID])
REFERENCES [dbo].[Suppliers] ([SupplierID])
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Suppliers]
GO

ALTER TABLE [dbo].[Products]  WITH NOCHECK ADD  CONSTRAINT [CK_Products_UnitPrice] CHECK  (([UnitPrice] >= 0))
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [CK_Products_UnitPrice]
GO

ALTER TABLE [dbo].[Products]  WITH NOCHECK ADD  CONSTRAINT [CK_UnitsInStock] CHECK  (([UnitsInStock] >= 0))
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [CK_UnitsInStock]
GO

ALTER TABLE [dbo].[Products]  WITH NOCHECK ADD  CONSTRAINT [CK_UnitsOnOrder] CHECK  (([UnitsOnOrder] >= 0))
GO

ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [CK_UnitsOnOrder]
GO

ALTER TABLE [dbo].[Products] ADD  CONSTRAINT [DF_Products_UnitPrice]  DEFAULT (0) FOR [UnitPrice]
GO

ALTER TABLE [dbo].[Products] ADD  CONSTRAINT [DF_Products_UnitsInStock]  DEFAULT (0) FOR [UnitsInStock]
GO

ALTER TABLE [dbo].[Products] ADD  CONSTRAINT [DF_Products_UnitsOnOrder]  DEFAULT (0) FOR [UnitsOnOrder]
GO

INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Beverages','Soft drinks, coffees, teas, beers, and ales')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Condiments','Sweet and savory sauces, relishes, spreads, and seasonings')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Confections','Desserts, candies, and sweet breads')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Dairy Products','Cheeses')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Grains/Cereals','Breads, crackers, pasta, and cereal')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Meat/Poultry','Prepared meats')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Produce','Dried fruit and bean curd')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Categories] VALUES ('Seafood','Seaweed and fish')

GO

select * from categories
GO


INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Exotic Liquids','Charlotte Cooper','Purchasing Manager','49 Gilbert St.','London',NULL,'EC1 4SD','UK','(171) 555-2222',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('New Orleans Cajun Delights','Shelley Burke','Order Administrator','P.O. Box 78934','New Orleans','LA','70117','USA','(100) 555-4822',NULL,'#CAJUN.HTM#')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Grandma Kellys Homestead','Regina Murphy','Sales Representative','707 Oxford Rd.','Ann Arbor','MI','48104','USA','(313) 555-5735','(313) 555-3349',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Tokyo Traders','Yoshi Nagase','Marketing Manager','9-8 Sekimai Musashino-shi','Tokyo',NULL,'100','Japan','(03) 3555-5011',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Pavlova Ltd.','Ian Devling','Marketing Manager','74 Rose St. Moonie Ponds','Melbourne','Victoria','3058','Australia','(03) 444-2343','(03) 444-6588',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Specialty Biscuits','Peter Wilson','Sales Representative','29 Kings Way','Manchester',NULL,'M14 GSD','UK','(161) 555-4448',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('PB Knäckebröd AB','Lars Peterson','Sales Agent','Kaloadagatan 13','Göteborg',NULL,'S-345 67','Sweden','031-987 65 43','031-987 65 91',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Refrescos Americanas LTDA','Carlos Diaz','Marketing Manager','Av. das Americanas 12.890','Sao Paulo',NULL,'5442','Brazil','(11) 555 4640',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Heli Süßwaren GmbH & Co. KG','Petra Winkler','Sales Manager','Tiergartenstraße 5','Berlin',NULL,'10785','Germany','(010) 9984510',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Plutzer Lebensmittelgroßmärkte AG','Martin Bein','International Marketing Mgr.','Bogenallee 51','Frankfurt',NULL,'60439','Germany','(069) 992755',NULL,'Plutzer (on the World Wide Web)#http://www.microsoft.com/accessdev/sampleapps/plutzer.htm#')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Nord-Ost-Fisch Handelsgesellschaft mbH','Sven Petersen','Coordinator Foreign Markets','Frahmredder 112a','Cuxhaven',NULL,'27478','Germany','(04721) 8713','(04721) 8714',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Formaggi Fortini s.r.l.','Elio Rossi','Sales Representative','Viale Dante, 75','Ravenna',NULL,'48100','Italy','(0544) 60323','(0544) 60603','#FORMAGGI.HTM#')
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Norske Meierier','Beate Vileid','Marketing Manager','Hatlevegen 5','Sandvika',NULL,'1320','Norway','(0)2-953010',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Bigfoot Breweries','Cheryl Saylor','Regional Account Rep.','3400 - 8th Avenue Suite 210','Bend','OR','97101','USA','(503) 555-9931',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Svensk Sjöföda AB','Michael Björn','Sales Representative','Brovallavägen 231','Stockholm',NULL,'S-123 45','Sweden','08-123 45 67',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Aux joyeux ecclésiastiques','Guylène Nodier','Sales Manager','203, Rue des Francs-Bourgeois','Paris',NULL,'75004','France','(1) 03.83.00.68','(1) 03.83.00.62',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Leka Trading','Chandra Leka','Owner','471 Serangoon Loop, Suite #402','Singapore',NULL,'0512','Singapore','555-8787',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Lyngbysild','Niels Petersen','Sales Manager','Lyngbysild Fiskebakken 10','Lyngby',NULL,'2800','Denmark','43844108','43844115',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Zaanse Snoepfabriek','Dirk Luchte','Accounting Manager','Verkoop Rijnweg 22','Zaandam',NULL,'9999 ZZ','Netherlands','(12345) 1212','(12345) 1210',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Karkki Oy','Anne Heikkonen','Product Manager','Valtakatu 12','Lappeenranta',NULL,'53120','Finland','(953) 10956',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Ma Maison','Jean-Guy Lauzon','Marketing Manager','2960 Rue St. Laurent','Montréal','Québec','H1J 1C3','Canada','(514) 555-9022',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Pasta Buttini s.r.l.','Giovanni Giudici','Order Administrator','Via dei Gelsomini, 153','Salerno',NULL,'84100','Italy','(089) 6547665','(089) 6547667',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Escargots Nouveaux','Marie Delamare','Sales Manager','22, rue H. Voiron','Montceau',NULL,'71300','France','85.57.00.07',NULL,NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Gai paturage','Eliane Noz','Sales Representative','Bat. B 3, rue des Alpes','Annecy',NULL,'74000','France','38.76.98.06','38.76.98.58',NULL)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Suppliers] VALUES('Forets derables','Chantal Goulet','Accounting Manager','148 rue Chasseur','Ste-Hyacinthe','Québec','J2S 7S8','Canada','(514) 555-2955','(514) 555-2921',NULL)

GO

INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chai',1,1,'10 boxes x 20 bags',18,39,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chang',1,1,'24 - 12 oz bottles',19,17,40)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Aniseed Syrup',1,2,'12 - 550 ml bottles',10,13,70)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chef Antons Cajun Seasoning',2,2,'48 - 6 oz jars',22,53,8)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chef Antons Gumbo Mix',2,2,'36 boxes',21.35,0,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Grandmas Boysenberry Spread',3,2,'12 - 8 oz jars',25,120,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Uncle Bobs Organic Dried Pears',3,7,'12 - 1 lb pkgs.',30,15,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Northwoods Cranberry Sauce',3,2,'12 - 12 oz jars',40,6,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Mishi Kobe Niku',4,6,'18 - 500 g pkgs.',97,29,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Ikura',4,8,'12 - 200 ml jars',31,31,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Queso Cabrales',5,4,'1 kg pkg.',21,22,30)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Queso Manchego La Pastora',5,4,'10 - 500 g pkgs.',38,86,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Konbu',6,8,'2 kg box',6,24,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Tofu',6,7,'40 - 100 g pkgs.',23.25,35,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Genen Shouyu',6,2,'24 - 250 ml bottles',15.5,39,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Pavlova',7,3,'32 - 500 g boxes',17.45,29,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Alice Mutton',7,6,'20 - 1 kg tins',39,0,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Carnarvon Tigers',7,8,'16 kg pkg.',62.5,42,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Teatime Chocolate Biscuits',8,3,'10 boxes x 12 pieces',9.2,25,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Sir Rodneys Marmalade',8,3,'30 gift boxes',81,40,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Sir Rodneys Scones',8,3,'24 pkgs. x 4 pieces',10,3,40)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gustafs Knäckebröd',9,5,'24 - 500 g pkgs.',21,104,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Tunnbröd',9,5,'12 - 250 g pkgs.',9,61,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Guaraná Fantástica',10,1,'12 - 355 ml cans',4.5,20,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('NuNuCa Nuß-Nougat-Creme',11,3,'20 - 450 g glasses',14,76,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gumbär Gummibärchen',11,3,'100 - 250 g bags',31.23,15,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Schoggi Schokolade',11,3,'100 - 100 g pieces',43.9,49,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Rössle Sauerkraut',12,7,'25 - 825 g cans',45.6,26,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Thüringer Rostbratwurst',12,6,'50 bags x 30 sausgs.',123.79,0,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Nord-Ost Matjeshering',13,8,'10 - 200 g glasses',25.89,10,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gorgonzola Telino',14,4,'12 - 100 g pkgs',12.5,0,70)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Mascarpone Fabioli',14,4,'24 - 200 g pkgs.',32,9,40)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Geitost',15,4,'500 g',2.5,112,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Sasquatch Ale',16,1,'24 - 12 oz bottles',14,111,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Steeleye Stout',16,1,'24 - 12 oz bottles',18,20,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Inlagd Sill',17,8,'24 - 250 g  jars',19,112,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gravad lax',17,8,'12 - 500 g pkgs.',26,11,50)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Cote de Blaye',18,1,'12 - 75 cl bottles',263.5,17,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chartreuse verte',18,1,'750 cc per bottle',18,69,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Boston Crab Meat',19,8,'24 - 4 oz tins',18.4,123,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Jacks New England Clam Chowder',19,8,'12 - 12 oz cans',9.65,85,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Singaporean Hokkien Fried Mee',20,5,'32 - 1 kg pkgs.',14,26,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Ipoh Coffee',20,1,'16 - 500 g tins',46,17,10)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gula Malacca',20,2,'20 - 2 kg bags',19.45,27,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Rogede sild',21,8,'1k pkg.',9.5,5,70)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Spegesild',21,8,'4 - 450 g glasses',12,95,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Zaanse koeken',22,3,'10 - 4 oz boxes',9.5,36,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Chocolade',22,3,'10 pkgs.',12.75,15,70)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Maxilaku',23,3,'24 - 50 g pkgs.',20,10,60)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Valkoinen suklaa',23,3,'12 - 100 g bars',16.25,65,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Manjimup Dried Apples',24,7,'50 - 300 g pkgs.',53,20,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Filo Mix',24,5,'16 - 2 kg boxes',7,38,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Perth Pasties',24,6,'48 pieces',32.8,0,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Tourtière',25,6,'16 pies',7.45,21,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Pate chinois',25,6,'24 boxes x 2 pies',24,115,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Vegie-spread',7,2,'15 - 625 g jars',43.9,24,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Wimmers gute Semmelknödel',12,5,'20 bags x 4 pieces',33.25,22,80)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Louisiana Fiery Hot Pepper Sauce',2,2,'32 - 8 oz bottles',21.05,76,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Louisiana Hot Spiced Okra',2,2,'24 - 8 oz jars',17,4,100)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Laughing Lumberjack Lager',16,1,'24 - 12 oz bottles',14,52,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Scottish Longbreads',8,3,'10 boxes x 8 pieces',12.5,6,10)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Gudbrandsdalsost',15,4,'10 kg pkg.',36,26,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Outback Lager',7,1,'24 - 355 ml bottles',15,15,10)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Flotemysost',15,4,'10 - 500 g pkgs.',21.5,26,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Mozzarella di Giovanni',14,4,'24 - 200 g pkgs.',34.8,14,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Röd Kaviar',17,8,'24 - 150 g jars',15,101,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Longlife Tofu',4,7,'5 kg pkg.',10,4,20)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Rhönbräu Klosterbier',12,1,'24 - 0.5 l bottles',7.75,125,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Lakkalik',23,1,'500 ml',18,57,0)
INSERT INTO [EmpresaPlazaLibre].[dbo].[Products] values('Original Frankfurter grüne Soße',12,2,'12 boxes',13,32,0)

GO

select * from products
GO
