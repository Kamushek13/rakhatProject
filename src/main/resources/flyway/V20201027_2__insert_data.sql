INSERT INTO category(id, name, description)
VALUES (1, 'candy',
        'confectionery products based on sugar syrup with the addition of various types of food raw materials.');
INSERT INTO category(id, name, description)
VALUES (2, 'chocolate',
        'confectionery product based on cocoa butter, which is a product of processing cocoa beans - the seeds of the chocolate tree, rich in theobromine and caffeine.');
INSERT INTO category(id, name, description)
VALUES (4, 'cookie', 'small flour confectionery products of various shapes and low humidity.');
INSERT INTO category(id, name, description)
VALUES (3, 'marmalade',
        'culinary product made from fruit, berry puree or juices boiled with sugar and moisture content');

INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (19, 'Turnir', 'Orange flavored cookies.', 185, 1,
        'fortified wheat flour, sugar, vegetable fat, corn starch, syrup, egg powder, table salt, baking powder, emulsifier, enzyme, flavor',
        4, 220, 63);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (20, 'Yubileinoe', 'Cookies with an original milk-creamy taste', 185, 1,
        'fortified wheat flour, vegetable fat, sugar, corn starch, syrup, table salt, baking powder, egg powder, emulsifier, enzyme, flavorings',
        4, 220, 24);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (16, 'Alatau', 'Cookies with baked milk flavor.', 185, 1,
        'fortified wheat flour, vegetable fat, sugar, corn starch, syrup, egg powder, baking powder, table salt, emulsifier, enzyme, flavor',
        4, 220, 75);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (3, 'Altyn Kum',
        'Chocolate praline based on almonds, cocoa butter and grated cocoa, with the addition of butter, crunchy waffle crumbs and vanilla aroma.',
        20, 1,
        'sugar, vegetable fats, grated almond kernel, grated cocoa, wheat flour, cocoa mass/butter/powder, emulsifiers, butter, corn starch, egg powder, table salt, baking powder antioxidant, flavor, vanillin',
        1, 20, 300);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (2, 'Aitys',
        'Combined domed fondant candy coated with chocolate glaze. The shell of the body is made of milk fondant with the addition of cocoa powder with vanilla aroma. The filling is based on natural hazelnut paste.',
        20, 1,
        'sugar, milk with sugar, molasses, cocoa mass/butter/powder, hazelnut paste, vegetable fats, sorbitol, ethyl alcohol, stabilizer, flavorings',
        1, 10, 1000);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (1, 'Aygerim',
        'The shell of the body is made of milk fondant with caramel-vanilla aroma with the addition of cocoa powder and alcohol. Milk fondant filling with cognac.',
        20, 1,
        'sugar, milk with sugar, molasses, cocoa mass/butter/powder, vegetable fat, ethyl alcohol, table salt, stabilizer, cognac, flavorings',
        1, 10, 1000);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (4, 'Blues',
        'Delicate milk praline based on peanuts, with the addition of grated cocoa, cocoa powder, crushed peanuts, with the aroma of roasted hazelnuts.',
        20, 1, 'sugar, vegetable fats, cocoa mass/butter/powder, grated peanuts, crushed peanuts, emulsifiers', 1, 25,
        400);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (5, 'Kupiya',
        'Dome-shaped chocolate-glazed sweets with or without a pattern. The body consists of a mass of "toffee" type.',
        20, 1,
        'syrup, sugar, milk with sugar, vegetable fat, cocoa mass/butter/powder, moisture retaining agent, table salt, emulsifiers, stabilizer, butter, flavorings',
        1, 15, 500);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (10, 'iQube', 'Natural chocolate with the addition of crushed peanuts and a light vanilla aroma', 70, 10,
        'sugar, crushed peanuts, cocoa butter/mass, milk fat, emulsifier, fructose, crushed almond kernel, natural vanilla extract',
        2, 70, 200);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (8, 'Almaty', 'Aerated dark chocolate airy tenderness of dark chocolate with a slight bitterness', 90, 10,
        'sugar, cocoa mass/butter/powder, emulsifier, table salt, natural vanilla extract', 2, 190, 150);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (9, 'Suyinshi',
        'Bitter chocolate made according to the classical technology from high-quality cocoa beans, with a cocoa content of at least 75%, with a natural vanilla aroma',
        210, 10, 'sugar, cocoa mass/butter/powder, emulsifier, table salt, natural vanilla extract', 2, 130, 170);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (6, 'Desire',
        'A unique chocolate set with fruit fillings that will not leave indifferent any connoisseur of sweets.', 107,
        10, 'sugar, cocoa mass/butter/powder, caramel paste, cherry, orange, caramel, raspberry', 2, 150, 100);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (7, 'Kazyna', 'Curly dark chocolate in the form of coins with a relief image of tenge, euro and ruble', 160, 10,
        'sugar, cocoa mass/butter, emulsifiers, natural vanilla extract', 2, 170, 90);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (15, 'CreamBerry',
        'Two-color marmalade, sprinkled with sugar, in the form of "pudding", with aromas of strawberry with cream and blueberry with cream.',
        250, 1, 'molasses, sugar, sorbitol, gelling agents, citric acid, carnauba wax, flavorings, food coloring', 3,
        300, 17);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (14, 'Jelly Sugar', 'Fruit jelly of various colors with fruit and berry flavor.', 250, 1,
        'molasses, sugar, sorbitol, gelling agents, citric acid, carnauba wax, flavorings, food coloring', 3, 300, 33);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (11, 'Fairytale', 'Marmalade in the form of sweets with the taste of various fruits and berries.', 250, 1,
        'molasses, sugar, sorbitol, gelling agents, citric acid, carnauba wax, flavors, food coloring, safflower extract',
        3, 300, 20);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (12, 'Tropicana', 'Marmalade in the form of orange slices with tropical fruit flavor.', 250, 1,
        'molasses, sugar, sorbitol, gelling agents, citric acid, carnauba wax, flavorings, food coloring', 3, 300, 22);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (13, 'Fruit', 'Fruit jelly sprinkled with sugar, with taste and aroma of prunes and apricots.', 250, 1,
        'molasses, sugar, sorbitol, gelling agents, citric acid, carnauba wax, flavorings, food coloring', 3, 300, 25);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (17, 'Koktem', 'Orange flavored cookies.', 185, 1,
        'fortified wheat flour, sugar, vegetable fat, corn starch, table salt, leavening agents, emulsifier, enzyme, flavoring',
        4, 220, 100);
INSERT INTO product(id, name, description, weight, unit, composition, category_id, price, stock)
VALUES (18, 'Arman', 'Orange flavored cookies.', 185, 1,
        'fortified wheat flour, vegetable fat, sugar, corn starch, molasses, egg powder, table salt, baking powder, emulsifier, enzyme, flavor',
        4, 220, 82);

INSERT INTO auth (username, password, customer_id)
VALUES ('admin', 'root', 1);

INSERT INTO customer (fullname, phone, email, address, company, auth_id)
VALUES ('aruzhan', '217721', 'aru@mail.ru', 'Aru Street', 'Google', 1);