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
      title: 'Лабораторна робота №5 - обробка рядка',
      theme: ThemeData(
        primarySwatch: Colors.deepOrange,
      ),
      home: const StringProcessingHomePage(
          title: 'ЛР №5 - Оброка рядка - Стартова Сторінка'),
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

  var items = [
    'К-сть великих і малих',
    'Почергово маленькі і великі'
  ];

  int curIndex = 0;
  String dropdownvalue = 'К-сть великих і малих';

  void _getCountBigAndSmall() {
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

  void _showBigAndSmall() {
    setState(() {
      String newStr = "";
      for (int i = 0; i < _textEditCtr.text.length; i++) {
        if (i % 2 == 0) {
          newStr += _textEditCtr.text[i].toLowerCase();
        } else {
          newStr += _textEditCtr.text[i].toUpperCase();
        }
      }
      _res = "Новий рядок: $newStr";
    });
  }

  void _controllerHandlingString() {
    switch (curIndex) {
      case 0: _getCountBigAndSmall();
        break;
      case 1: _showBigAndSmall();
        break;
    }
  }

  void _pushResult() {
    _controllerHandlingString();
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => ResultStringHandler(_res)),
    );
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
                'Програма для обробки рядка',
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
            Padding(
              padding: const EdgeInsets.only(top: 16, right: 8, bottom: 8, left: 8),
              child: DropdownButton(
                value: dropdownvalue,
                icon: const Icon(Icons.keyboard_arrow_down),

                items: items.map((String items) {
                  return DropdownMenuItem(
                    value: items,
                    child: Text(items),
                  );
                }).toList(),

                onChanged: (String? newValue) {
                  setState(() {
                    dropdownvalue = newValue!;
                    curIndex = items.indexOf(newValue);
                  });
                },
              ),
            ),
            ElevatedButton(
              onPressed: _pushResult,
              child: const Text('Обробити'),
            ),
          ],
        ),
      ),
    );
  }
}

class ResultStringHandler extends StatelessWidget {
  final String displayText;
  const ResultStringHandler(this.displayText, {super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Результат програми'),
      ),
      body: Center(
        child: Text(
          displayText,
          style: const TextStyle(fontSize: 20.0, fontWeight: FontWeight.bold),
          textAlign: TextAlign.center,
        ),
      ),
    );
  }
}
