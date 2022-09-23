CREATE TABLE prices (
    id INTEGER NOT NULL AUTO_INCREMENT,
    brand_id INTEGER NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    price_list INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    curr VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);