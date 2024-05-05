CREATE TRIGGER trigger_alteracao_tabela AFTER UPDATE ON tb_cliente
    FOR EACH ROW
BEGIN
    INSERT INTO tb_log_alteracoes (action, table_name, row_id, timestamp)
    VALUES ('UPDATE', 'tb_cliente', NEW.id, NOW());
END;
