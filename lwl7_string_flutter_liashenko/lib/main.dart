import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Лабораторна робота №4 - обробка рядка',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const StringProcessingHomePage(
          title: 'ЛР №4 - Оброка рядка - Стартова Сторінка'),
    );
  }
}

class StringProcessingHomePage extends StatefulWidget {
  const StringProcessingHomePage({super.key, required this.title});
  final String title;

  @override
  State<StringProcessingHomePage> createState() =>
      _StringProcessingHomePageState();
}

class _StringProcessingHomePageState extends State<StringProcessingHomePage> {
  final textEditCtr = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            const Padding(
              padding: EdgeInsets.only(top: 16, right: 4, bottom: 8, left: 4),
              child: Text(
                'Зробити першу половину букв рядка великими',
                style: TextStyle(fontSize: 22.0),
                textAlign: TextAlign.center,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 16, right: 8, bottom: 8, left: 8),
              child: TextField(
                controller: textEditCtr,
                decoration: const InputDecoration(
                  border: UnderlineInputBorder(),
                  hintText: 'Введіть рядок',
                ),
              ),
            ),
            ElevatedButton(
              onPressed: () {
                String stringVal = textEditCtr.text;
                for (int i = 0; i < stringVal.length; i++) {

                }
              },
              child: const Text('Обробити'),
            ),
            const Padding(
              padding: EdgeInsets.only(top: 16, right: 4, bottom: 8, left: 4),
              child: Text(
                'Результат',
                style: TextStyle(fontSize: 22.0, fontWeight: FontWeight.bold),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
