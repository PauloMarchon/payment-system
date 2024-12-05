CREATE TABLE users(
    id UUID PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    identification_number VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    phone_number VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);