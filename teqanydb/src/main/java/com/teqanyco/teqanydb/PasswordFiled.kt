import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.teqanyco.teqanydb.R


@Composable
fun PasswordTextField() {
    var text by rememberSaveable { mutableStateOf("") }
    var visible by rememberSaveable { mutableStateOf(false) }
    val icon = if (visible) painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    else
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Password here") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { visible = !visible }) {
                Icon(
                    painter = icon,
                    contentDescription = "password"
                )
            }
        },

        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true
    )


}