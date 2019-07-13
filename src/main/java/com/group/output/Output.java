package com.group.output;

import com.group.repository.Repository;

import javax.swing.*;

public interface Output {
    JPanel show(String userInput, Repository repository);
}
