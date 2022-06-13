#!/usr/bin/env jython
'''
"Hello, World!" in Jython and JavaFX

Roughly based on this: https://fxdocs.github.io/docs/html5/#_scene_graph
'''
import sys

from javafx.application import Application
from javafx.scene import Scene
from javafx.scene.layout import StackPane

class HelloWorld(Application):

    @classmethod
    def main(cls, args):
        HelloWorld.launch(cls, args)

    def start(self, stage):
        stage.setTitle('Hello World!')
        stage.setScene(Scene(StackPane(), 320, 240))
        stage.show()


if __name__ == '__main__':
    HelloWorld.main(sys.argv)