INSERT INTO equipments
(id, description, serial_number, model, type, status, latitude, longitude)
VALUES
(123456, 'Prensa Hidráulica Xtreme', '123456', 'XYZ', 'MACHINE', 'AVAILABLE', -29.63935, -50.78878),
(123457, 'Cortadora a Laser Alpha', '123457', 'ABC', 'MACHINE', 'IN_MAINTENANCE', -29.62145, -50.78565),
(123458, 'Braço Robótico Z-2000', '123458', 'DEF', 'DEVICE', 'IN_MAINTENANCE', -29.60234, -50.77698),
(123459, 'Impressora 3D ProtoMaster', '123459', 'GHI', 'TOOL', 'AVAILABLE', -29.65432, -50.77321),
(123460, 'Fresadora CNC HyperPrecision', '123460', 'JKL', 'MACHINE', 'AVAILABLE', -29.65532, -50.78532),
(123461, 'Máquina de Solda FusionPro', '123461', 'ABC', 'TOOL', 'IN_MANUFACTURING', -29.62345, -50.78965),
(123462, 'Misturador Industrial ThunderBolt', '123462', 'DEF', 'MACHINE', 'AVAILABLE', -29.66789, -50.78887),
(123463, 'Linha de Montagem PowerFlow', '123463', 'GHI', 'MACHINE', 'IN_MANUFACTURING', -29.64576, -50.76987),
(123464, 'Correia Transportadora SpeedKing', '123464', 'JKL', 'DEVICE', 'AVAILABLE', -29.67854, -50.76543),
(123465, 'Bomba Hidráulica TitanForce', '123465', 'ABC', 'MACHINE', 'UNAVAILABLE', -29.65432, -50.75654);

INSERT INTO employees
(id, name, email, phone_number, address, specialization, shift, employee_type)
VALUES
(1, 'John Doe', 'john@doe.com', '999999999', 'Endereço Teste 1', 'GENERAL', null, 'Technician'),
(2, 'John Mechanic', 'john@mec.com', '999999999', 'Endereço Teste 2', 'MECHANICAL', null, 'Technician'),
(3, 'John Electric', 'john@electric.com', '999999999', 'Endereço Teste 3', 'ELECTRICAL', null, 'Technician'),
(4, 'Jane Doe', 'jane@doe.com', '999999999', 'Endereço Teste 4', null, 'MORNING', 'Operator'),
(5, 'Emily White', 'emily@white.com', '999999999', 'Endereço Teste 5', null, 'MORNING', 'Operator'),
(6, 'Michael Brown', 'michael@brown.com', '999999999', 'Endereço Teste 6', 'GENERAL', null, 'Technician'),
(7, 'Chris Green', 'chris@green.com', '999999999', 'Endereço Teste 7', null, 'MORNING', 'Operator'),
(8, 'Oliver Black', 'oliver@black.com', '999999999', 'Endereço Teste 8', null, 'MORNING', 'Operator'),
(9, 'Sophia Smith', 'sophia@smith.com', '999999999', 'Endereço Teste 9', null, 'MORNING', 'Operator'),
(10, 'Lucas Grey', 'lucas@grey.com', '999999999', 'Endereço Teste 10', null, null, 'ManufactureManager');

INSERT INTO manufacture_orders
(id, order_number, description, created_at, updated_at, finished_at, equipment_id, employee_id, order_status)
VALUES
(1, 'ORD-00001', 'Produção de Engrenagens de Alta Precisão', CURRENT_TIMESTAMP, NULL, NULL, 123457, 4, 'CREATED'),
(2, 'ORD-00002', 'Corte de Metal Personalizado', CURRENT_TIMESTAMP, NULL, NULL, 123458, 5, 'CREATED'),
(3, 'ORD-00003', 'Tarefa de Montagem Automatizada', CURRENT_TIMESTAMP, NULL, NULL, 123459, 6, 'IN_PROGRESS'),
(4, 'ORD-00004', 'Criação de Peça Protótipo', CURRENT_TIMESTAMP, NULL, NULL, 123460, 7, 'IN_PROGRESS'),
(5, 'ORD-00005', 'Execução de Produção em Massa', CURRENT_TIMESTAMP, NULL, NULL, 123461, 8, 'CREATED'),
(6, 'ORD-00006', 'Fabricação de Componente de Reparo', CURRENT_TIMESTAMP, NULL, NULL, 123462, 9, 'FINISHED'),
(7, 'ORD-00007', 'Criação de Junta Soldada Especial', CURRENT_TIMESTAMP, NULL, NULL, 123463, 10, 'FINISHED'),
(8, 'ORD-00008', 'Usinagem de Peça de Teste', CURRENT_TIMESTAMP, NULL, NULL, 123464, 1, 'CREATED'),
(9, 'ORD-00009', 'Fabricação de Caixa de Engrenagens de Alto Torque', CURRENT_TIMESTAMP, NULL, NULL, 123465, 2, 'IN_PROGRESS'),
(10, 'ORD-00010', 'Produção de Encaixe Único', CURRENT_TIMESTAMP, NULL, NULL, 123465, 3, 'FINISHED');

INSERT INTO manufacture_order_items
(id, description, quantity, non_conforming_quantity, unit, shift, manufacture_order_id)
VALUES
(1, 'Engrenagem de Precisão', 100, 0, 'PIECE', 'REGULAR', 1),
(2, 'Placa de Metal Personalizada', 50, 2, 'PIECE', 'NIGHT', 2),
(3, 'Montagem de Braço Robótico', 75, 1, 'PIECE', 'MORNING', 3),
(4, 'Widget de Protótipo', 20, 0, 'PIECE', 'MORNING', 4),
(5, 'Junta Soldada Especial', 40, 3, 'PIECE', 'REGULAR', 5),
(6, 'Rolo de Transportador de Alta Velocidade', 60, 1, 'PIECE', 'NIGHT', 6),
(7, 'Lâmina de Misturador Industrial', 80, 4, 'PIECE', 'AFTERNOON', 7),
(8, 'Montagem PowerFlow', 90, 5, 'PIECE', 'MORNING', 8),
(9, 'Carcaça de Caixa de Engrenagens', 70, 2, 'PIECE', 'AFTERNOON', 9),
(10, 'Carcaça de Bomba Hidráulica', 30, 1, 'PIECE', 'NIGHT', 10);

INSERT INTO maintenance_orders
(id, reason, created_at, updated_at, finished_at, equipment_id, type, priority, order_status)
VALUES
(1, 'Verificação de Calibração de Rotina', CURRENT_TIMESTAMP, NULL, NULL, 123457, 'PRODUCTION', 'LOW', 'CREATED'),
(2, 'Protocolo de Reparo de Emergência', CURRENT_TIMESTAMP, NULL, NULL, 123458, 'PRODUCTION', 'HIGH', 'IN_PROGRESS'),
(3, 'Substituição Programada de Peça', CURRENT_TIMESTAMP, NULL, NULL, 123459, 'PRODUCTION', 'MEDIUM', 'IN_PROGRESS'),
(4, 'Procedimento de Revisão Crítica', CURRENT_TIMESTAMP, NULL, NULL, 123460, 'PRODUCTION', 'HIGH', 'FINISHED'),
(5, 'Rotina de Manutenção Preventiva', CURRENT_TIMESTAMP, NULL, NULL, 123461, 'PRODUCTION', 'LOW', 'CREATED'),
(6, 'Inspeção de Caixa de Engrenagens', CURRENT_TIMESTAMP, NULL, NULL, 123462, 'PRODUCTION', 'MEDIUM', 'FINISHED'),
(7, 'Teste do Sistema Hidráulico', CURRENT_TIMESTAMP, NULL, NULL, 123463, 'PRODUCTION', 'HIGH', 'IN_PROGRESS'),
(8, 'Depuração do Sistema de Controle', CURRENT_TIMESTAMP, NULL, NULL, 123464, 'PRODUCTION', 'LOW', 'CREATED'),
(9, 'Lubrificação de Componentes', CURRENT_TIMESTAMP, NULL, NULL, 123465, 'PRODUCTION', 'LOW', 'FINISHED'),
(10, 'Conserto de Emergência', CURRENT_TIMESTAMP, NULL, NULL, 123465, 'PRODUCTION', 'HIGH', 'IN_PROGRESS');

INSERT INTO maintenance_order_items
(id, description, shift, employee_id, maintenance_order_id, started_at, finished_at)
VALUES
(1, 'Ferramentas de Calibração', 'MORNING', 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Kit de Peças Sobressalentes', 'AFTERNOON', 6, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Kit de Lubrificação', 'NIGHT', 8, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Substituição Hidráulica', 'MORNING', 5, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Placa de Circuito do Sistema de Controle', 'MORNING', 1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Kit de Manutenção de Caixa de Engrenagens', 'AFTERNOON', 7, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Kit de Reparo de Emergência', 'AFTERNOON', 9, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Substituição de Fluido Hidráulico', 'REGULAR', 3, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'Conjunto de Ferramentas de Precisão', 'REGULAR', 10, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Equipamento de Diagnóstico', 'NIGHT', 2, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);