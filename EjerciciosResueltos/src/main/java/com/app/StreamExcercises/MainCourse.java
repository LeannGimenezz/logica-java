package com.app.StreamExcercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainCourse {
    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Cursos profesional de Java", 6.5f, 50, 200 ));
        courses.add(new Course("Cursos profesional de Python", 8.5f, 60, 800 ));
        courses.add(new Course("Cursos profesional de DB", 4.5f, 70, 700 ));
        courses.add(new Course("Cursos profesional de Android", 7.5f, 10, 400 ));
        courses.add(new Course("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        //Obtener la cantidad de cursos con una duración mayor a 5 horas.

        Long count1 = courses.stream().filter(c -> c.getDuracion() > 5).count();
        System.out.println(count1);
        System.out.println("---------------------");

        //Obtener la cantidad de cursos con una duración menor a 2 horas.
        Long count2 = courses.stream().filter(c -> c.getDuracion() < 2).count();
        System.out.println(count2);
        System.out.println("---------------------");

        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        courses.stream().filter(c -> c.getVideos() > 50).forEach(c -> System.out.println(c.getTitulo()));
        System.out.println("---------------------");

        //Mostrar en consola el título de los 3 cursos con mayor duración.
        Comparator<Course> comparatorDuration = Comparator.comparingDouble(c -> c.getDuracion());
        courses.stream().sorted(comparatorDuration.reversed()).limit(3).forEach(c -> System.out.println(c.getTitulo()));
        System.out.println("---------------------");

        //Mostrar en consola la duración total de todos los cursos.
        courses.stream().forEach(c -> System.out.println(c.getDuracion()));
        System.out.println("---------------------");

        //Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
        double avgDuration = courses.stream().mapToInt(e -> (int) e.getDuracion()).average().orElse(0);
        System.out.println(avgDuration);
        courses.stream()
                .filter(e -> e.getDuracion() > (float) avgDuration)
                .forEach(c -> System.out.println(c.getTitulo()));
        System.out.println("---------------------");

        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        courses.stream().filter(c -> c.getAlumnos() < 500).map(c -> c.getTitulo()).forEach(System.out::println);
        System.out.println("---------------------");

        //Obtener el curso con mayor duración.
        Course course = courses.stream().max(Comparator.comparingInt(c -> (int) c.getDuracion())).get();
        System.out.println(course.toString());
        System.out.println("---------------------");


        //Crear una lista de Strings con todos los titulos de los cursos.
        List<String> titles = courses.stream().map(Course::getTitulo).collect(Collectors.toList());
        System.out.println(titles);
    }
}
