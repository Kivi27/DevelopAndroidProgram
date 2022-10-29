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
        primarySwatch: Colors.amber,
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
  final _textEditCtr = TextEditingController();
  String _res = "Результат: ";

  void _processingString() {
    setState(() {
      int countBigLetter = 0;
      String newStr = _textEditCtr.text.replaceAll(RegExp('[^A-Za-z\u0406\u0407\u0456\u0457\u0401\u0451\u0410-\u044f]'),'');
      for (int i = 0; i < newStr.length; i++) {
        if (newStr[i] == newStr[i].toUpperCase()) {
          countBigLetter++;
        }
      }
      int countSmallLetter = newStr.length - countBigLetter;
      _res = "Кількість великих буква: $countBigLetter,\n малих букв: $countSmallLetter";
    });
  }

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
                'Показати кількість великих і малих букв в рядку',
                style: TextStyle(fontSize: 22.0),
                textAlign: TextAlign.center,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 16, right: 8, bottom: 8, left: 8),
              child: TextField(
                controller: _textEditCtr,
                decoration: const InputDecoration(
                  border: UnderlineInputBorder(),
                  hintText: 'Введіть рядок',
                ),
              ),
            ),
            ElevatedButton(
              onPressed: _processingString,
              child: const Text('Обробити'),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 16, right: 4, bottom: 8, left: 4),
              child: Text(
                _res,
                style: const TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
                textAlign: TextAlign.center,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
