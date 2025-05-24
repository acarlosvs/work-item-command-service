-- Criação da tabela workitems_tb
CREATE TABLE workitems_tb (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(150) NOT NULL,
    user_id UUID NOT NULL,
    board_id UUID NOT NULL
);
