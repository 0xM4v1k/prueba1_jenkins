pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Clone') {
            steps {
                timeout(time: 10, unit: 'MINUTES'){
                    // Especifica la rama master explícitamente para mayor claridad.
                    git branch: 'master', url: 'https://github.com/0xM4v1k/prueba1_jenkins.git'
                }
            }
        }
        stage('Build') {
            steps {
                timeout(time: 10, unit: 'MINUTES'){
                    // Corregido: El pom.xml está en la raíz del workspace después del clone
                    sh "mvn -DskipTests clean package"
                }
            }
        }
        stage('Test') {
            steps {
                timeout(time: 10, unit: 'MINUTES'){
                    // Se cambia <test> por <install> para que se genere el reporte de jacoco
                    // Corregido: El pom.xml está en la raíz del workspace
                    sh "mvn clean install"
                }
            }
        }
        stage('Sonar') {
            steps {
                timeout(time: 10, unit: 'MINUTES'){
                    withSonarQubeEnv('sonarqube'){ // Asegúrate que 'sonarqube' es el nombre de tu server SonarQube en la config de Jenkins
                        sh "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar -Pcoverage"
                    }
                }
            }
        }
        stage('Quality gate') {
            steps {
                sleep(10) //seconds

                timeout(time: 10, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Deploy & Access Setup') {
            steps {
                echo "🚀 Iniciando aplicación con acceso web..."
                script {
                    sh """
                        # Iniciar la aplicación Spring Boot
                        mvn spring-boot:run -f pom.xml &
                        sleep 25
                        
                        # Crear un simple proxy HTTP usando Python
                        cat > /tmp/h2_proxy.py << 'EOF'
        import http.server
        import socketserver
        import urllib.request
        import urllib.parse
        from urllib.error import URLError
        
        class ProxyHandler(http.server.BaseHTTPRequestHandler):
            def do_GET(self):
                try:
                    target_url = f"http://localhost:8081{self.path}"
                    req = urllib.request.Request(target_url)
                    
                    # Copiar headers del request original
                    for header, value in self.headers.items():
                        if header.lower() not in ['host']:
                            req.add_header(header, value)
                    
                    with urllib.request.urlopen(req) as response:
                        self.send_response(response.status)
                        
                        # Copiar headers de la respuesta
                        for header, value in response.headers.items():
                            self.send_header(header, value)
                        self.end_headers()
                        
                        # Copiar el contenido
                        self.wfile.write(response.read())
                except Exception as e:
                    self.send_error(500, f"Proxy Error: {str(e)}")
            
            def do_POST(self):
                self.do_GET()
        
        PORT = 8082
        with socketserver.TCPServer(("", PORT), ProxyHandler) as httpd:
            print(f"Proxy running on port {PORT}")
            httpd.serve_forever()
        EOF
        
                        # Ejecutar el proxy en background
                        python3 /tmp/h2_proxy.py &
                        PROXY_PID=\$!
                        sleep 5
                        
                        echo "✅ Aplicación Spring Boot corriendo en puerto 8081"
                        echo "🌐 Proxy HTTP corriendo en puerto 8082"
                        echo ""
                        echo "📊 ACCESO A H2 CONSOLE:"
                        echo "   URL: http://localhost:8082/h2-console"
                        echo "   JDBC URL: jdbc:h2:mem:testdb"
                        echo "   Usuario: tokito"
                        echo "   Password: wazaaa123"
                        echo ""
                        echo "⏰ Manteniendo servicios activos por 10 minutos..."
                        
                        # Mantener activo por 10 minutos
                        sleep 600
                        
                        # Limpiar procesos
                        kill \$PROXY_PID 2>/dev/null || true
                        pkill -f spring-boot:run 2>/dev/null || true
                    """
                }
            }
        }
    }
}

