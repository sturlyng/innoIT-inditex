# InnoIT-Inditex
Technical test to InnoIT-Inditex

#### Suposiciones
- He puesto todos los campos numéricos como Integer(excepto el precio) porque para el ejemplo no vamos a tener valores tan grandes como para poner Long.
- En el precio uso un BigDecimal por la mejor precisión que tiene sobre Double
- El tipo de la moneda lo he puesto como String pero debería ser un enum o una tabla en la base de datos.
- Ambas fechas (startDate y endDate) son inclusive.
- Las fechas están en formato UTC, por lo tanto las pruebas habría que hacerlas con 2 horas menos de la que queramos realmente, ya que España ahora (horario de verano) está en UTC+2
- Además he considerado que las fechas de todos los datos proporcionados en la prueba son hora española.
- Hago un índice por los dos campos principales porque sólo tenemos una query a la tabla que usa los dos.