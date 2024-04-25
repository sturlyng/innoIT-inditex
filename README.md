# InnoIT-Inditex
Technical test to InnoIT-Inditex

#### Suposiciones
- He puesto todos los campos numéricos como Integer(excepto el precio) porque para el ejemplo no vamos a tener valores tan grandes como para poner Long.
- El tipo de la moneda lo he puesto como String pero debería ser un enum o una tabla en la base de datos.
- Ambas fechas (startDate y endDate) son inclusive.
- Hago un índice por los dos campos principales porque sólo tenemos una query a la tabla que usa los dos.