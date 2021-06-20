import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {OrganizationModel} from "../../models/organizations/organization.model";

@Component({
  selector: 'app-add-organization',
  templateUrl: './add-organization.component.html',
  styleUrls: ['./add-organization.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AddOrganizationComponent implements OnInit {
  organizationForm: FormGroup;
  emailPattern = '^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}$';
  types: string[] = ['UNIVERSITY', 'COMPANY'];

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.organizationForm = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      description: this.fb.control('', [Validators.required, Validators.minLength(8)]),
      url: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.maxLength(200)]),
      address: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.maxLength(150)]),
      email: this.fb.control('', [Validators.required, this.noWhitespaceValidator, Validators.pattern(this.emailPattern), Validators.maxLength(50)]),
      organizationType: this.fb.control('')
    });
  }

  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  _organization(organizationForm: FormGroup): OrganizationModel {
    return organizationForm as unknown as OrganizationModel;

  }
}
