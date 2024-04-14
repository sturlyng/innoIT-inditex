CREATE TABLE prices (
    id INTEGER NOT NULL AUTO_INCREMENT,
    brand_id INTEGER NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    priority_order INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    curr VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);