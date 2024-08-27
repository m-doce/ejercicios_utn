# Ejercicio micros empresarios
ACME S.A. tiene una planta modelo en una bucólica zona rural lejos del tráfago urbano.

Para que la gente pueda llegar a la planta, la empresa tiene varios micros contratados. En cada micro
entran *N* pasajeros sentados y *M* parados, donde el *N* y el *M* son particulares de cada micro (no son todos
los micros iguales).

**La gente no es toda igual, entonces para subirse a un micro se fija en distintas cosas:**

- Los apurados se suben siempre
- Los claustrofóbicos se suben sólo si el micro tiene más de 120 m³ de volumen (se sabe el volumen de
cada micro)
- Los fiacas se suben sólo si entran sentados
- Los moderados se suben sólo si quedan al menos *X* lugares libres (no importa si sentados o parados),
donde el *X* es particular de cada persona moderada.
- Los obsecuentes toman la misma decisión que tomaría su jefe (de cada empleado se sabe quién es su
jefe, que es otro empleado)

**Modelar los micros y las personas de forma tal que:**
- Se pueda preguntarle a una persona si es jefe.
- Se pueda preguntarle a un micro si se puede subir a una persona, para lo cual tienen que darse dos
condiciones:
  - que haya lugar en el micro
  - que la persona acepte ir en el micro
- Se pueda hacer subir una persona a un micro. Si no puede, que tire error
- Se pueda hacer bajar una persona de un micro. Si no se puede (porque está vacío), que tire error
- Se pueda preguntarle a un micro quién fue el primero que se subió, null si está vacío