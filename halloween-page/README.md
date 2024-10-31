# README.md

# Proyecto Halloween Page

Este proyecto es una página web dedicada a Halloween, que incluye información sobre su historia, actividades y una galería de imágenes.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de archivos:

```
halloween-page
├── public
│   ├── css
│   │   └── styles.css        # Estilos CSS para la página
│   ├── js
│   │   └── scripts.js        # Scripts de JavaScript para interactividad
│   └── images                # Imágenes para la galería y secciones
├── views
│   ├── layouts
│   │   └── application.html.erb  # Plantilla principal
│   ├── index.html.erb        # Página de inicio
│   ├── introduction.html.erb  # Introducción sobre Halloween
│   ├── history.html.erb      # Historia de Halloween
│   ├── activities.html.erb   # Actividades relacionadas con Halloween
│   └── gallery.html.erb      # Galería de imágenes
├── config.ru                  # Configuración para Rack
├── Gemfile                    # Dependencias del proyecto
└── README.md                  # Documentación del proyecto
```

## Instalación

1. Clona el repositorio:
   ```
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Navega al directorio del proyecto:
   ```
   cd halloween-page
   ```

3. Instala las gemas necesarias:
   ```
   bundle install
   ```

4. Inicia el servidor:
   ```
   rackup
   ```

5. Abre tu navegador y visita `http://localhost:9292`.

## Uso

La página incluye varias secciones:

- **Introducción**: Información general sobre Halloween.
- **Historia**: Detalles sobre los orígenes y evolución de Halloween.
- **Actividades**: Descripción de actividades relacionadas con la celebración.
- **Galería**: Imágenes que capturan la esencia de Halloween.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.