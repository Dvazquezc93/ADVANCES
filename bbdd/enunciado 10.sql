-- Boletín 1 de ejercicios: group by, subconsultas y join
-- bbdd: 7. BBDD productos-compras Archivo

--1. Indica cuántos productos hay por material. Pon de alias "Total" a la columna con el número de productos
SELECT MATERIAL, COUNT(*) "TOTAL" FROM PRODUCTOS GROUP BY MATERIAL;
--2. Obtén el precio medio de los productos por empresa proveedor. El resultado del precio medio debe estar redondeado a 2 decimales.
SELECT PROVEEDORES.EMPRESA, ROUND(AVG(PRECIO),2)
FROM PRODUCTOS JOIN PROVEEDORES ON PRODUCTOS.PROV = PROVEEDORES.ID 
GROUP BY PROVEEDORES.EMPRESA;
--3. Para cada empresa proveedor indica el número de productos que suministra. El nombre de la empresa debe estar con la primera letra en mayúsculas y las restantes en minúsculas.
SELECT INITCAP(PROVEEDORES.EMPRESA),COUNT(PRODUCTOS.ID) FROM PRODUCTOS 
JOIN PROVEEDORES ON PRODUCTOS.PROV = PROVEEDORES.ID 
GROUP BY PROVEEDORES.EMPRESA;
--4. Muestra el peso máximo y el peso mínimo de los productos para cada material. Añade la letra "g" después de los valores máximos y mínimos.
SELECT MAX(PESO)|| 'G ',MIN(PESO)|| 'G ' FROM PRODUCTOS GROUP BY PRODUCTOS.MATERIAL;
--5. ¿Cuántas compras hay por año?
SELECT TO_CHAR(COMPRAS.FECHA,'YYYY'),COUNT(*) FROM COMPRAS GROUP BY TO_CHAR(COMPRAS.FECHA,'YYYY');

--6. A partir de la query anterior, indica solo las que sean en año impar
SELECT TO_CHAR(COMPRAS.FECHA,'YYYY'),COUNT(*) FROM COMPRAS GROUP BY TO_CHAR(COMPRAS.FECHA,'YYYY') HAVING MOD(TO_CHAR(COMPRAS.FECHA,'YYYY'),2)<>0;
--7. Para cada cliente (muestra el nombre) se quiere saber el número de compras realizadas, la fecha de la primera compra y la fecha de la última que haya hecho
SELECT CLIENTES.NOMBRE, COUNT(*),MIN(COMPRAS.FECHA),MAX(COMPRAS.FECHA) 
 FROM COMPRAS JOIN CLIENTES ON CLIENTES.ID =COMPRAS.CLI GROUP BY CLIENTES.NOMBRE;
--8. Se quiere mostrar el mes, el año y el número de compras realizadas para cada mes y año, ordenando los resultados primero por año y después por mes
SELECT TO_CHAR(COMPRAS.FECHA,'MM'),TO_CHAR(COMPRAS.FECHA,'YYYY'), COUNT(*) FROM COMPRAS GROUP BY TO_CHAR(COMPRAS.FECHA,'YYYY'),TO_CHAR(COMPRAS.FECHA,'MM');
--9. Muestra de cada proveedor (empresa) cuántos productos, el precio medio de estos, así como el precio máximo y mínimo. Todos los campos de precios deben ir con dos decimales truncados.
SELECT PROVEEDORES.EMPRESA, COUNT(*), AVG(PRODUCTOS.PRECIO), MAX(PRODUCTOS.PRECIO), MIN(PRODUCTOS.PRECIO) FROM PRODUCTOS JOIN PROVEEDORES ON PROVEEDORES.ID= PRODUCTOS.PROV GROUP BY PROVEEDORES.EMPRESA;
--10. Por cada cliente (su nombre) y material de producto, se quiere saber cuántas compras y la suma de total del gasto (precios de productos comprados). Del resultado filtra quedándote solo con los que tengan como mínimo 2 compras realizadas.
SELECT CLIENTES.NOMBRE, PRODUCTOS.MATERIAL, COUNT(*), SUM(PRECIO)
    FROM COMPRAS
    JOIN CLIENTES ON CLIENTES.ID = COMPRAS.CLI
    JOIN PRODUCTOS ON PRODUCTOS.ID = COMPRAS.PRO
    GROUP BY CLIENTES.NOMBRE, PRODUCTOS.MATERIAL
    HAVING COUNT(*) >= 2;