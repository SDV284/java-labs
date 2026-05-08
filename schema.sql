CREATE TABLE phones (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    brand VARCHAR(100),
    model VARCHAR(100),
    price DECIMAL,
    quantity INTEGER,
    screen_size DOUBLE PRECISION,
    os VARCHAR(50),
    has_flashlight BOOLEAN,
    ip_rating INTEGER,
    folding_cycles INTEGER
);