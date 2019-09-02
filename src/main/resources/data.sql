INSERT INTO product_category (name,status) 
	VALUES
		('Roupas',true),
		('Eletrônicos',true),
		('Gift cards',true);

INSERT INTO product (name, unit_price, description, brand, status,prod_cat_category_id) 
	VALUES
		('Camiseta Branca',20.00, 'Camiseta branca sem estampa', 'Marisa', true,1),
		('TV SAMSUNG 4K', 1700.00, 'TV SAMSUNG 4K COM HDR', 'SAMSUNG', true, 2),
		('Cartão Xbox Live Gold', 130.00, 'Cartão pré pago para assinatura de Xbox Live Gold', 'MICROSOFT', true, 3);
		
INSERT INTO client (adress_cep
					,adress_city
					,adress_complement
					,adress_neighborhood
					,adress_number
					,adress_state
                    ,adress_street
					,birth_date
					,cpf
					,email
					,genre
					,lastname
					,name
					,password
					,phone_number
					,status
					) 
			VALUES
					('89230-729'
					,'Joinville'
					,'Casa de esquina'
					,'Adhemar Garcia'
					,'162'
					,'SC'
					,'Rua Doutor Oswaldo Altino Dória'
					,'1998-09-07 00:00:00'
					,'107.276.969-71'
					,'andreluis2006@outlook.com'
					,'M'
					,'Cardoso'
					,'André Luis'
					,'senha1234'
					,'(47) 99217-2668'
					,1
					);
		