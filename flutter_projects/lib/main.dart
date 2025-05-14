import 'package:flutter/material.dart';

void main()
{
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: const Text("Hello Flutter")),
      body: const Column(
        children: [
          MyApp(),
          MyButton()
        ],
      )),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        width: 200,
        height: 200,
        alignment: Alignment.center,
        margin: const EdgeInsets.fromLTRB(0, 60, 0, 0),
        decoration: BoxDecoration(
          color: Colors.black,
          borderRadius: BorderRadius.circular(20),
          border: Border.all(
              color: Colors.red,
              width: 10),
          boxShadow: const [
            BoxShadow(
              color: Colors.black,
              blurRadius: 10
            )
          ]
        ),

        child: const Text("P21", style: TextStyle(
            color: Colors.white,
            fontSize: 25))
      )
    );
  }
}

class MyButton extends StatelessWidget {
  const MyButton({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        width: 200,
        height: 50,
        margin: const EdgeInsets.all(80),
        alignment: Alignment.center,
        decoration: BoxDecoration(
            color: Colors.blue,
            borderRadius: BorderRadius.circular(20),
            boxShadow: const[
              BoxShadow(
                color: Colors.blue,
                blurRadius: 2
              )
            ],
        ),
        child: const Text("按紐", style: TextStyle(
            color: Colors.white,
            fontSize: 25
        )),
      ),
    );

  }
}
