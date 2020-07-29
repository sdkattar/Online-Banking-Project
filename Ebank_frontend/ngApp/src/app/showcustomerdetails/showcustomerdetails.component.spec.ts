import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcustomerdetailsComponent } from './showcustomerdetails.component';

describe('ShowcustomerdetailsComponent', () => {
  let component: ShowcustomerdetailsComponent;
  let fixture: ComponentFixture<ShowcustomerdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowcustomerdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowcustomerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
