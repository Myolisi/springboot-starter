package com.spring.springstarter.core.classes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor //Constructor with no arguments
public class ErrorMessageClass {
    // @NotNull will be added to the constructor
    @NonNull private int status;
    @NonNull private String message;

    // this final and assigned field will not be included
    final private boolean isError = true;
}
