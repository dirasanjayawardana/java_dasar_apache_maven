# Apache Maven
Merupakan salah satu tools untuk melakukan build automation (compile, build, packaging, testing, membuat dokumentasi, manajemen dependency)
- Compile --> Source Code - Compile - Binary File
- Packaging --> Binary file - packaging - Distributon file (jar, war, ear)
- Membuat dokumentasi --> source code - compile doc - documentation
- Testing --> test code - testing - test result

## Membuat Project Java Menggunakan Apache Maven
- Download apche maven (maven.apache.ord), tambahkan path bin
- Di maven project dibuat menggunakan archetype (template project)
- Jalankan `mvn-archetype:generate`
- Pilih template dengan mengetikkan `maven-archetype-quickstart`
- jika sudha selesai, buka file pom.xml, sesuaikan versi `maven.compiler.source` dan `maven.compiler.target` dengan versi java yg digunakan

## Struktur Project
- src (lokasi source code)
- taget (hasil compile source code)
- pom.xml (berisi konfigurasi project, beserta dependency)

## Lifecycle
Maven berkerja dalam konsep lifecycle. Lifecycle akan menjalankan banyak plugin.
Untuk menjalankan lifecycle menggunakan `mvn namaLifeCycle`
Beberapa Lifecycle di Maven:
- `mvn clean` (menghspus folder target/tempat menyimpan hasil compile)
- `mvn compile` (melakukan compile soruce code project)
- `mvn test-compile` (melakukan compile test code project)
- `mvn test` (menjalankan unit test)
- `mvn package` (membuat distribution file)
- `mvn install` (menginstall project ke local repository, sehingga bisa digunakan di project lain di local)
- `mvn deploy` (deploy project ke remote repository di server)

## Build Project
#### Hasil dari build project berupa distribution file yang berisi binary code dari project, namun dependency tidak termasuk didalamnya.
- Untuk melakukan build project, bisa menggunakan perintah `clean`, `compile`, `test`(jika sekalian ingin menjalankan unit testnya) dan `package`
- Bisa digabung menjadi satu perintah sekaligus: `mvn clean compile test package`
- Maven akan build satu buah file jar di folder Target yang siap dirunning dengan perintah `java -jar target/namaFile.jar`

#### Jika ingin distribution file yg dihasilkan include semua dependecy, bisa gunakan Plugin, contohnya Assembly Plugin.
- Tambahkan plugin di file pom.xml pada tag `<plugins>`
- Tentukan main class nya di tag `<mainClass>`
- Kemudian jalankan perintah `mvn package assembly:single`
- Akan dihaasilkan satu file distribution di folder Targer yang siap dirunning dengan perintah `java -jar target/namaFile.jar`

## Dependency Management
Saat menambahkan dependecy ke project Maven, harus menentukan scope(ruang lingkup) dependecy tersebut.
Beberapa scope dependency antara lain:
- compile (scope default, untuk build project, test project dan menjalankan project)
- test (scope untuk test project saja)

Untuk menambahkan dependency, tambahkan pada tag `<dependencies>` di file pom.xml maka dependecy akan otomatis di download dari repository
Untuk mencari dependency bisa buka halaman `https://search.maven.org` atau `https://mvnrepository.com`

## Menambah Repository
Jika dependency yg dibutuhkan tidak ada di default maven repository, bisa tambahkan repository di file pom.xml
pada tag `<repositories>`

## Maven Peoperties
Maven mendukung properties untuk menyimpan data konfiugrasi yang dapat digunakan di file pom.xml
Bisa tambahkan data konfigurasi di file pom.xml pada tag `<properties>` dengan aturan `<nama.properties>value</nama.properties>`
Untuk menggunakannya cukup dengan `${nama.properties}` pada field pom.xml