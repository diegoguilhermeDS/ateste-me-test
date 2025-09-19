import { AbstractControl, ValidatorFn } from '@angular/forms';

export function matchValidator(matchTo: string): ValidatorFn {
  return (control: AbstractControl) => {
    const parent = control.parent;
    if (!parent) return null;
    const matchingControl = parent.get(matchTo);
    if (!matchingControl) return null;

    return control.value === matchingControl.value ? null : { mismatch: true };
  };
}
