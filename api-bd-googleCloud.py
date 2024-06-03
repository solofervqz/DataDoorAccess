import requests
import mysql.connector

# Recuperar los datos JSON desde la URL
print("Recuperando datos desde la URL...")
url = "https://sii.chihuahua2.tecnm.mx/serv_web/alumnos.php?operacion=todos&token=biblioteca"
response = requests.get(url)
data = response.json()
print("Datos recuperados correctamente")

# Conectarse a la base de datos MySQL
print("Conectándose a la base de datos MySQL...")
conexion = mysql.connector.connect(
    host="34.121.129.3",
    user="admin",
    password="tecnologicoII",
    database="bibliotec"
)
print("Conexión exitosa")

cursor = conexion.cursor()

# Iterar sobre los datos JSON y insertarlos en la base de datos
print("Insertando datos en la base de datos...")
for registro in data:
    query = """INSERT INTO alumnos (noControl, apellidoPaterno, apellidoMaterno, nombre, carrera, genero)
               VALUES (%s, %s, %s, %s, %s, %s)
               ON DUPLICATE KEY UPDATE
               apellidoPaterno=VALUES(apellidoPaterno),
               apellidoMaterno=VALUES(apellidoMaterno),
               nombre=VALUES(nombre),
               carrera=VALUES(carrera),
               genero=VALUES(genero)"""
    values = (
        registro["no_de_control"].strip(),
        registro["apellido_paterno"].strip(),
        registro["apellido_materno"].strip(),
        registro["nombre_alumno"].strip(),
        registro["nombre_carrera"].strip(),
        registro["sexo"].strip()
    )
    cursor.execute(query, values)

# Confirmar los cambios y cerrar la conexión
conexion.commit()
print("Datos insertados correctamente y cambios confirmados")
conexion.close()
print("Conexión cerrada")
